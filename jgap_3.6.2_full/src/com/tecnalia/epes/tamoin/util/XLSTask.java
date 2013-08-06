package com.tecnalia.epes.tamoin.util;

public class XLSTask {

	private String weekNumber;
	private String windFarmNumber;
	private String maintenanceTeamName;
	private String taskName;
	private String windTurbineNumber;
	
	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}
	public String getWindFarmNumber() {
		return windFarmNumber;
	}
	public void setWindFarmNumber(String windFarmNumber) {
		this.windFarmNumber = windFarmNumber;
	}
	public String getMaintenanceTeamName() {
		return maintenanceTeamName;
	}
	public void setMaintenanceTeamName(String maintenanceTeamName) {
		this.maintenanceTeamName = maintenanceTeamName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getWindTurbineNumber() {
		return windTurbineNumber;
	}
	public void setWindTurbineNumber(String windTurbineNumber) {
		this.windTurbineNumber = windTurbineNumber;
	}	

	public String toString() {
		return "[Week: " + weekNumber + 
				", WindFarm: " + windFarmNumber +
				", MaintenanceTeam: " + maintenanceTeamName + 
				", TaskName: " + taskName +
				", WindTurbine: " + windTurbineNumber +				
				"]";
	}
}
