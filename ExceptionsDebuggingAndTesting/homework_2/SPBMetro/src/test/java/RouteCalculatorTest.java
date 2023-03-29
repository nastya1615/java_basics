import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    RouteCalculator calculator;
    StationIndex stationIndex;


    Line line1;
    Line line2;
    Line line3;


    Station sport;
    Station teatralnya;
    Station bezimyanka;

    Station kyevskya;
    Station moskovskaya;
    Station yngorodok;
    Station sovetskya;

    Station oktyabrskay;
    Station pobeda;
    Station samarskya;
    Station gagarinskya;
    Station aerokosmicheskya;

    List<Station> withTransferRoute;
    List<Station> withTwoTransferRoute;
    List<Station> withoutTransferRoute;

    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();

        route = new ArrayList<>();
        line1 = new Line(1, "Красная ветка");
        line2 = new Line(2, "Синяя ветка");
        line3 = new Line(3, "Оранжевая ветка");


        sport = new Station("Спортивная", line1);
        teatralnya = new Station("Театральная", line1);
        bezimyanka = new Station("Безымянка", line1);

        kyevskya = new Station("Киевская", line2);
        moskovskaya = new Station("Московская", line2);
        yngorodok = new Station("Юнгородок", line2);
        sovetskya = new Station("Советская", line2);

        oktyabrskay = new Station("Октябрьская", line3);
        pobeda = new Station("Победа", line3);
        samarskya = new Station("Самарская", line3);
        gagarinskya = new Station("Гагаринская", line3);
        aerokosmicheskya = new Station("Аэрокосмическая", line3);


        Stream.of(line1, line2).forEach(stationIndex::addLine);
        Stream.of(sport, teatralnya, bezimyanka, kyevskya, moskovskaya, yngorodok, sovetskya, oktyabrskay, pobeda, samarskya, gagarinskya, aerokosmicheskya).peek(s -> s.getLine().addStation(s)).forEach(stationIndex::addStation);
        stationIndex.addConnection(Stream.of(teatralnya, moskovskaya).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(kyevskya, aerokosmicheskya).collect(Collectors.toList()));

        calculator = new RouteCalculator(stationIndex);

        withTransferRoute = Stream.of(sport, teatralnya, moskovskaya, yngorodok, sovetskya).collect(Collectors.toList());
        withTwoTransferRoute = Stream.of(bezimyanka, teatralnya, moskovskaya, kyevskya, aerokosmicheskya, gagarinskya, samarskya, pobeda, oktyabrskay).collect(Collectors.toList());
        withoutTransferRoute = Stream.of(bezimyanka, teatralnya, sport).collect(Collectors.toList());

    }

    public void testGetShortestRoute() {

        List<Station> actualWithTransfer = calculator.getShortestRoute(sport, sovetskya);
        List<Station> actualWithTwoTransfer = calculator.getShortestRoute(bezimyanka, oktyabrskay);
        List<Station> actualWithoutTransfer = calculator.getShortestRoute(bezimyanka, sport);

        assertEquals(actualWithTransfer, withTransferRoute);
        assertEquals(actualWithTwoTransfer, withTwoTransferRoute);
        assertEquals(actualWithoutTransfer, withoutTransferRoute);


    }

    public  void testCalculateDuration(){

        double actual = RouteCalculator.calculateDuration(calculator.getShortestRoute(bezimyanka,samarskya));
        double Expected = 17;

        assertEquals(actual,Expected);



    }


}
