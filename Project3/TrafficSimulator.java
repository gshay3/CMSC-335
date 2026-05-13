/*
 * File Name: TrafficSimulator.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: The main entry point to start the simulation.
 */

package cmsc_335_project3;

import javax.swing.SwingUtilities;

public class TrafficSimulator 
{
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(() -> 
		{
			new Frame();
		});
	}
}
