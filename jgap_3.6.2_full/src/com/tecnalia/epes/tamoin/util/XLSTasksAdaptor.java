package com.tecnalia.epes.tamoin.util;

import java.util.ArrayList;

public class XLSTasksAdaptor {
		
	private ArrayList<GATask> gaTasksArrayList;
	
	public ArrayList<GATask> getGaTasks() {
		return gaTasksArrayList;
	}
	
	/**
	 * @param args	 
	 */
	public static void main(String[] args) {
		
	}

	public XLSTasksAdaptor(ArrayList<XLSTask> xlsTasksArrayList) {
		super();
		
		this.gaTasksArrayList = new ArrayList<GATask>();
		
		for (XLSTask xlsTask : xlsTasksArrayList) {			
			GATask gaTask = new GATask();
			gaTask.setName(xlsTask.getTaskName());
			gaTask.setMaintenanceTeamNames(xlsTask.getMaintenanceTeamName());
			gaTask.setWindFarm(Integer.parseInt(xlsTask.getWindFarmNumber()));
			gaTask.setWindTurbine(Integer.parseInt(xlsTask.getWindTurbineNumber()));
			gaTask.setPriority(getPriority(xlsTask.getTaskName()));
			gaTask.setDuration(getDuration(xlsTask.getTaskName()));
			gaTask.setMaintenanceTeams(getMaintenanceTeamsRequired(xlsTask.getTaskName()));
			gaTask.setWindSpeedLimit(getWindSpeedLimit(xlsTask.getTaskName()));
			gaTasksArrayList.add(gaTask);		
		}		
	}
	
	private int getWindSpeedLimit(String taskName) {
		int windSpeedLimit = 0;
		switch (taskName) {
		case "ACCION CORRECTORA ANALITICA":
			windSpeedLimit = 15;
			break;
		case "CAMBIO ACEITE GH":
			windSpeedLimit = 15;
			break;
		case "CAMBIO ACEITE MULTI":
			windSpeedLimit = 15;
			break;
		case "CAMBIO ACEITE REDUCTORAS YAW":
			windSpeedLimit = 15;
			break;
		case "CAMBIO RODAMIENTO GEN":
			windSpeedLimit = 15;
			break;
		case "COMP ALINEADO":
			windSpeedLimit = 15;
			break;
		case "COP":
			windSpeedLimit = 15;
			break;
		case "GC GENERADOR":
			windSpeedLimit = 15;
			break;
		case "GC MULTI":
			windSpeedLimit = 15;
			break;
		case "GC ROTOR":
			windSpeedLimit = 15;
			break;
		case "PENDIENTE PREVENTIVO":
			windSpeedLimit = 15;
			break;
		case "PREVENTIVO 6M":
			windSpeedLimit = 15;
			break;
		case "PREVENTIVO OTROS":
			windSpeedLimit = 15;
			break;
		}
		return windSpeedLimit;
	}

	public int getDuration(String taskName) {
		int duration = 0;
		switch (taskName) {
		case "ACCION CORRECTORA ANALITICA":
			duration = 2;
			break;
		case "CAMBIO ACEITE GH":
			duration = 2;
			break;
		case "CAMBIO ACEITE MULTI":
			duration = 2;
			break;
		case "CAMBIO ACEITE REDUCTORAS YAW":
			duration = 2;
			break;
		case "CAMBIO RODAMIENTO GEN":
			duration = 7;
			break;
		case "COMP ALINEADO":
			duration = 1;
			break;
		case "COP":
			duration = 0;
			break;
		case "GC GENERADOR":
			duration = 7;
			break;
		case "GC MULTI":
			duration = 7;
			break;
		case "GC ROTOR":
			duration = 7;
			break;
		case "PENDIENTE PREVENTIVO":
			duration = 7;
			break;
		case "PREVENTIVO 6M":
			duration = 7;
			break;
		case "PREVENTIVO OTROS":
			duration = 7;
			break;
		}
		return duration;	
	}
	
	public int getMaintenanceTeamsRequired(String taskName) {
		int maintenanceTeams = 0;
		switch (taskName) {
		case "ACCION CORRECTORA ANALITICA":
			maintenanceTeams = 1;
			break;
		case "CAMBIO ACEITE GH":
			maintenanceTeams = 1;
			break;
		case "CAMBIO ACEITE MULTI":
			maintenanceTeams = 1;
			break;
		case "CAMBIO ACEITE REDUCTORAS YAW":
			maintenanceTeams = 1;
			break;
		case "CAMBIO RODAMIENTO GEN":
			maintenanceTeams = 1;
			break;
		case "COMP ALINEADO":
			maintenanceTeams = 1;
			break;
		case "COP":
			maintenanceTeams = 0;
			break;
		case "GC GENERADOR":
			maintenanceTeams = 3;
			break;
		case "GC MULTI":
			maintenanceTeams = 3;
			break;
		case "GC ROTOR":
			maintenanceTeams = 4;
			break;
		case "PENDIENTE PREVENTIVO":
			maintenanceTeams = 1;
			break;
		case "PREVENTIVO 6M":
			maintenanceTeams = 1;
			break;
		case "PREVENTIVO OTROS":
			maintenanceTeams = 1;
			break;
		}
		return maintenanceTeams;	
	}
	
	public int getPriority(String taskName) {
		int priority = 0;
		switch (taskName) {
		case "ACCION CORRECTORA ANALITICA":
			priority = 2;
			break;
		case "CAMBIO ACEITE GH":
			priority = 1;
			break;
		case "CAMBIO ACEITE MULTI":
			priority = 1;
			break;
		case "CAMBIO ACEITE REDUCTORAS YAW":
			priority = 1;
			break;
		case "CAMBIO RODAMIENTO GEN":
			priority = 2;
			break;
		case "COMP ALINEADO":
			priority = 1;
			break;
		case "COP":
			priority = 1;
			break;
		case "GC GENERADOR":
			priority = 3;
			break;
		case "GC MULTI":
			priority = 3;
			break;
		case "GC ROTOR":
			priority = 3;
			break;
		case "PENDIENTE PREVENTIVO":
			priority = 1;
			break;
		case "PREVENTIVO 6M":
			priority = 1;
			break;
		case "PREVENTIVO OTROS":
			priority = 1;
			break;
		}
		return priority;	
	}
}
