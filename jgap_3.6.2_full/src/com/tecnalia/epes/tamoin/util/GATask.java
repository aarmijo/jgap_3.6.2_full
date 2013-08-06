package com.tecnalia.epes.tamoin.util;

public class GATask {
	
	private int duration;

	private int windFarm;
	
	private int windTurbine;
	
	private int maintenanceTeams;
	
	private String name;
	
	private int priority;
	
	private String maintenanceTeamNames;
	
	private int windSpeedLimit;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getWindFarm() {
		return windFarm;
	}

	public void setWindFarm(int windFarm) {
		this.windFarm = windFarm;
	}

	public int getWindTurbine() {
		return windTurbine;
	}

	public void setWindTurbine(int windTurbine) {
		this.windTurbine = windTurbine;
	}

	public int getMaintenanceTeams() {
		return maintenanceTeams;
	}

	public void setMaintenanceTeams(int maintenanceTeams) {
		this.maintenanceTeams = maintenanceTeams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getMaintenanceTeamNames() {
		return maintenanceTeamNames;
	}

	public void setMaintenanceTeamNames(String maintenanceTeamNames) {
		this.maintenanceTeamNames = maintenanceTeamNames;
	}	
	
	public int getWindSpeedLimit() {
		return windSpeedLimit;
	}

	public void setWindSpeedLimit(int windSpeedLimit) {
		this.windSpeedLimit = windSpeedLimit;
	}

	public String toString() {
		return "GATask [Name: " + name + 
				", Duration: " + duration +
				", WindFarm: " + windFarm + 
				", WindTurbine: " + windTurbine +
				", MaintenanceTeams: " + maintenanceTeams +
				", Priority: " + priority +
				", MaintenanceTeamNames: " + maintenanceTeamNames +
				", WindSpeedLimit: " + windSpeedLimit +
				"]";
	}
}
