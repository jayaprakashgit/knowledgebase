package com.interlan.test.problem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MaximumDistanceCover {

	public static double total_fuel_avialble = 50000;
	public static double speed = 6;
	public static double[] speed_limit = {250, 240, 230, 220, 210, 211};
	public static double[] km_covers = {5000, 4500, 4000, 3500, 3000, 3000};
	public static Map<Double, Double> speed_km_map = new HashMap<>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<speed; i++){
			speed_km_map.put(speed_limit[i], km_covers[i]);
		}
		
		double max_distance = 0;
		
		for (Map.Entry<Double, Double> speed_km_map_entry : speed_km_map.entrySet()) {
			if( ((total_fuel_avialble / speed_km_map_entry.getValue()) * speed_km_map_entry.getKey()) > max_distance)
				max_distance = ((total_fuel_avialble / speed_km_map_entry.getValue()) * speed_km_map_entry.getKey());
		}
		
		System.out.println("max_distance : "+max_distance);
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.UP);
		System.out.println("max_distance : "+df.format(max_distance));
	}

}
