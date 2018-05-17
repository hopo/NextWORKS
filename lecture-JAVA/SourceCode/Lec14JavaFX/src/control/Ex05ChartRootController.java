package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class Ex05ChartRootController implements Initializable {
	
	@FXML PieChart pieChart;
	@FXML BarChart barChart;
	@FXML AreaChart areaChart;
	@FXML LineChart lineChart;
	@FXML StackedBarChart stackedBarChart;
	@FXML BubbleChart bubbleChart;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// ! Pie
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("JavaFX", 53), // ;; static nested class
				new PieChart.Data("Swing", 27),
				new PieChart.Data("SWT", 12),
				new PieChart.Data("AWT", 8)
		));
		

		// ! Bar
		XYChart.Series<String, Number> barSeries1 = new XYChart.Series<>();
		barSeries1.setName("Men");
		barSeries1.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  70),
				new XYChart.Data("yr2106",  60),
				new XYChart.Data("yr2107",  80),
				new XYChart.Data("yr2108",  40)
		));

		XYChart.Series<String, Number> barSeries2 = new XYChart.Series<>();
		barSeries2.setName("Women");
		barSeries2.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  50),
				new XYChart.Data("yr2106",  70),
				new XYChart.Data("yr2107",  60),
				new XYChart.Data("yr2108",  50)
		));
		
		barChart.getData().add(barSeries1);
		barChart.getData().add(barSeries2);

		
		// ! Area
		XYChart.Series<String, Number> areaSeries1 = new XYChart.Series<>();
		areaSeries1.setName("Thermometer");
		areaSeries1.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  20),
				new XYChart.Data("yr2106",  17),
				new XYChart.Data("yr2107",  21),
				new XYChart.Data("yr2108",  19)
		));

		XYChart.Series<String, Number> areaSeries2 = new XYChart.Series<>();
		areaSeries2.setName("Humidity");
		areaSeries2.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  60),
				new XYChart.Data("yr2106",  50),
				new XYChart.Data("yr2107",  55),
				new XYChart.Data("yr2108",  60)
		));

		areaChart.getData().addAll(areaSeries1, areaSeries2);

		// ! Line
		XYChart.Series<String, Number> lineSeries1 = new XYChart.Series<>();
		lineSeries1.setName("Men");
		lineSeries1.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  70),
				new XYChart.Data("yr2106",  60),
				new XYChart.Data("yr2107",  80),
				new XYChart.Data("yr2108",  40)
		));

		XYChart.Series<String, Number> lineSeries2 = new XYChart.Series<>();
		lineSeries2.setName("Women");
		lineSeries2.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  50),
				new XYChart.Data("yr2106",  70),
				new XYChart.Data("yr2107",  60),
				new XYChart.Data("yr2108",  50)
		));

		lineChart.getData().addAll(lineSeries1, lineSeries2);

		// ! Stack
		XYChart.Series<String, Number> stackSeries1 = new XYChart.Series<>();
		stackSeries1.setName("Men");
		stackSeries1.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  70),
				new XYChart.Data("yr2106",  60),
				new XYChart.Data("yr2107",  80),
				new XYChart.Data("yr2108",  40)
		));

		XYChart.Series<String, Number> stackSeries2 = new XYChart.Series<>();
		stackSeries2.setName("Women");
		stackSeries2.setData(FXCollections.observableArrayList(
				new XYChart.Data("yr2105",  50),
				new XYChart.Data("yr2106",  70),
				new XYChart.Data("yr2107",  60),
				new XYChart.Data("yr2108",  50)
		));

		stackedBarChart.getData().addAll(stackSeries1, stackSeries2);

		// ! Bubble
		XYChart.Series<Number, Number> bubbleSeries1 = new XYChart.Series<>();
		bubbleSeries1.setName("Men");
		bubbleSeries1.setData(FXCollections.observableArrayList(
				new XYChart.Data(45, 70, 15),
				new XYChart.Data(25, 60, 10),
				new XYChart.Data(50, 80, 20),
				new XYChart.Data(30, 40, 10)
		));

		XYChart.Series<Number, Number> bubbleSeries2 = new XYChart.Series<>();
		bubbleSeries2.setName("Women");
		bubbleSeries2.setData(FXCollections.observableArrayList(
				new XYChart.Data(56, 50, 5),
				new XYChart.Data(30, 70, 15),
				new XYChart.Data(60, 60, 15),
				new XYChart.Data(80, 50, 20)
		));

		bubbleChart.getData().addAll(bubbleSeries1, bubbleSeries2);
	}
}
