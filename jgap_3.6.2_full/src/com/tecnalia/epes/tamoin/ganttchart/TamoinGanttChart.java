package com.tecnalia.epes.tamoin.ganttchart;

/**
 * @Author Kushal Paudyal
 * www.sanjaal.com/java
 * Last Modified On: 2009-September 25
 *
 * Demonstrating the use of JFreeChart to create
 * Gantt Chart
 **/

import java.awt.Color;
import java.awt.Paint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jgap.IChromosome;

import com.tecnalia.epes.tamoin.MaintenanceTaskGene;
import com.tecnalia.epes.tamoin.WindFarm;
import com.tecnalia.epes.tamoin.util.cmis.CMISConnector;

public class TamoinGanttChart {

	private static final long serialVersionUID = 3488074583840465632L;

	private IChromosome bestSolutionSoFar;	

	private static Date makeDate(final int day, final int month, final int year) {

		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		final Date result = calendar.getTime();
		return result;

	}

	/**
	 * Creates a Gantt chart based on input data set
	 */
	private JFreeChart createChart(final IntervalCategoryDataset dataset) {
		final JFreeChart chart = ChartFactory.createGanttChart(
				"Tamoin Tasks Scheduling", // chart title
				"Task", // domain axis label
				"Date", // range axis label
				dataset, // data
				true, // include legend
				true, // tooltips
				false // urls
				);
		
		chart.setBorderVisible(false);
        chart.setBackgroundPaint(new Color(255, 255, 255));

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        GanttRenderer renderer = new GanttRenderer() {

			private static final long serialVersionUID = 1L;

			public Paint getItemPaint(int row, int column) {

				if (((MaintenanceTaskGene) bestSolutionSoFar.getGene(column))
						.getWindFarm() == 1) {
					return Color.RED;
				}
				if (((MaintenanceTaskGene) bestSolutionSoFar.getGene(column))
						.getWindFarm() == 2) {
					return Color.BLUE;
				} 
				if (((MaintenanceTaskGene) bestSolutionSoFar.getGene(column))
						.getWindFarm() == 3) {
					return Color.GREEN;
				}				
                return DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE[column];
            }
        };
        plot.setRenderer(renderer);

        renderer.setMaximumBarWidth(0.1); //prevent very thick bar when only one task
		      
        return chart;
	}

	public void saveChart(JFreeChart chart, String fileLocation) {
		String fileName = fileLocation;
		try {
			/**
			 * This utility saves the JFreeChart as a JPEG First Parameter:
			 * FileName Second Parameter: Chart To Save Third Parameter: Height
			 * Of Picture Fourth Parameter: Width Of Picture
			 */
			ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 2048, 768*2);			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problem occurred creating chart.");
		}
	}
	
	public void saveChartInVCN(JFreeChart chart, double[] kpis, boolean leverageBC1ContentModel, WindFarm[] windFarms, 
			boolean optimizeCosts, boolean optimizeAvailability, String weekNumber, double fitnessValue) {		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ChartUtilities.writeChartAsJPEG(baos, chart, 2048, 768*2);
			byte[] content = baos.toByteArray();			
			CMISConnector connector = new CMISConnector();
			connector.saveGanttChartInVCN(content, kpis,
					leverageBC1ContentModel, windFarms, optimizeCosts,
					optimizeAvailability, weekNumber, fitnessValue);			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problem occurred creating chart.");
		}
	}

	// Entry point
	public static void createGanttChart(IChromosome bestSolutionSoFar, boolean saveGanttChartToVCN, 
			boolean leverageBC1ContentModel, double[] kpis, WindFarm[] windFarms, boolean optimizeCosts, 
			boolean optimizeAvailability, String weekNumber, double fitnessValue) {

		final TamoinGanttChart chartCreator = new TamoinGanttChart();
		chartCreator.setBestSolutionSoFar(bestSolutionSoFar);
		
		System.out.println("...Creating Dataset");
		IntervalCategoryDataset dataset = createDataset(bestSolutionSoFar);

		System.out.println("...Creating Chart");
		JFreeChart chart = chartCreator.createChart(dataset);
		
		if (saveGanttChartToVCN == false) {
			
			String fileName = "/home/epes/TamoinGantChart-" + new Timestamp((new java.util.Date()).getTime()) + ".jpg";

			System.out.println("...Saving the Chart");
			chartCreator.saveChart(chart, fileName);

			System.out.println("...Chart Created Successfully and Saved");
			System.out.println("Output Chart File Location: " + fileName);
			
		} else {
			
			// Save the Gantt chart into the VCN
			System.out.println("...Saving the Chart into the VCN");
			chartCreator.saveChartInVCN(chart, kpis, leverageBC1ContentModel, windFarms, 
					optimizeCosts, optimizeAvailability, weekNumber, fitnessValue);
			
			System.out.println("...Chart Created Successfully and Saved");
			
		}

	}

	private static IntervalCategoryDataset createDataset(
			IChromosome bestSolutionSoFar) {
		/**
		* Creating a task series
		* And adding planned tasks dates on the series.
		*/
		Calendar calendar = Calendar.getInstance();		
		
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);
		
		
		TaskSeries seriesOne = new TaskSeries("Windfarm 1");
		TaskSeries seriesTwo = new TaskSeries("Windfarm 2");
		TaskSeries seriesThree = new TaskSeries("Windfarm 3");
		
		for (int i = 0; i < bestSolutionSoFar.size(); i++) {
			MaintenanceTaskGene task = (MaintenanceTaskGene) bestSolutionSoFar.getGene(i);
			for (int j = 0; j < task.getLength(); j++) {
				boolean taskPlanned = task.getBit(j);
				if (taskPlanned) {					
					Calendar now = Calendar.getInstance();  
					int weekday = now.get(Calendar.DAY_OF_WEEK);  
					if (weekday != Calendar.MONDAY)  
					{  
					    // calculate how much to add  
					    // the 2 is the difference between Saturday and Monday  
					    int days = (Calendar.SATURDAY - weekday + 2) % 7;  
					    now.add(Calendar.DAY_OF_YEAR, days);  
					    now.set(Calendar.HOUR_OF_DAY, 8);
						now.set(Calendar.MINUTE, 0);
						now.set(Calendar.SECOND, 0);
					}  else {
						now.set(Calendar.HOUR_OF_DAY, 8);
						now.set(Calendar.MINUTE, 0);
						now.set(Calendar.SECOND, 0);
					}
					
					// now is the date we want  
					//String format = new SimpleDateFormat(...).format(date);
					
					// Calculate Gantt bar for a single day task
					// Set now in the beginning of the task from Monday
					now.add(Calendar.DAY_OF_YEAR, j);	
					// Get the init date
					Date initTaskDate = now.getTime();	
					// Add the duration of the task
					now.add(Calendar.HOUR_OF_DAY, task.getDuration());
					// Get the end date
					Date endTaskDate = now.getTime();
					
					// calculate Gantt bar for second consecutive day of the task
					Date initTaskDateSecondDay = null;
					Date endTaskDateSecondDay = null;
					if (task.getDurationSecondDay() > 0) {
						now.add(Calendar.DAY_OF_YEAR, 1);
						now.set(Calendar.HOUR_OF_DAY, 8);
						initTaskDateSecondDay = now.getTime();
						
						now.add(Calendar.HOUR_OF_DAY, task.getDurationSecondDay());
						endTaskDateSecondDay = now.getTime();
					}
					
					// calculate Gantt bar for third consecutive day of the task
					Date initTaskDateThirdDay = null;
					Date endTaskDateThirdDay = null;
					if (task.getDurationSecondDay() > 0 && task.getDurationThirdDay() > 0) {
						now.add(Calendar.DAY_OF_YEAR, 1);
						now.set(Calendar.HOUR_OF_DAY, 8);
						initTaskDateThirdDay = now.getTime();
						
						now.add(Calendar.HOUR_OF_DAY, task.getDurationThirdDay());
						endTaskDateThirdDay = now.getTime();
					}					
					
					String taskName = (i + 1) + "-" + task.getName() + "-WF" + task.getWindFarm() + "-WT" + task.getWindTurbine() + "-" + task.getMaintenanceTeamNames();					
					
    				if (initTaskDateSecondDay != null && initTaskDateThirdDay == null) {
    					seriesTwo.add(new Task(taskName,
    							new SimpleTimePeriod(initTaskDate, endTaskDateSecondDay)));
    				} else if (initTaskDateSecondDay != null && initTaskDateThirdDay != null) {
    					seriesTwo.add(new Task(taskName,
    							new SimpleTimePeriod(initTaskDate, endTaskDateThirdDay)));
    				} else {
    					seriesTwo.add(new Task(taskName,
    							new SimpleTimePeriod(initTaskDate, endTaskDate)));
    				}
				
					break;
				}
			}
		}	

		 
		final TaskSeriesCollection collection = new TaskSeriesCollection();
		 
		/**
		* Adding the series to the collection
		* Holds actual Dates.
		*/
		collection.add(seriesOne);
		collection.add(seriesTwo);
		collection.add(seriesThree);
		
		return collection;
	}

	public IChromosome getBestSolutionSoFar() {
		return bestSolutionSoFar;
	}

	public void setBestSolutionSoFar(IChromosome bestSolutionSoFar) {
		this.bestSolutionSoFar = bestSolutionSoFar;
	}
}