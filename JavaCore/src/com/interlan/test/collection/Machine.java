package com.interlan.test.collection;

public class Machine {



	private int machineId;
	private String machineName;

	public Machine(int machineId, String machineName) {
		super();
		this.machineId = machineId;
		this.machineName = machineName;
	}

	public int getMachineId() {
		return machineId;
	}
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	
	@Override
	public String toString() {
		return "Machine [machineId=" + machineId + ", machineName=" + machineName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + machineId;
		result = prime * result + ((machineName == null) ? 0 : machineName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machine other = (Machine) obj;
		if (machineId != other.machineId)
			return false;
		if (machineName == null) {
			if (other.machineName != null)
				return false;
		} else if (!machineName.equals(other.machineName))
			return false;
		return true;
	}

}
