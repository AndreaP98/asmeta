package org.asmeta.simulationUI;

import java.util.List;

import org.asmeta.runtime_container.RunOutput;

public interface IModelCompositionContainer {
	
	/**
	 * Get the list of all the compositions available.
	 * @return the list of compositions.
	 */
	public List<Composition> getCompositionList();
	
	/**
	 * Add a composition to the internal composition list.
	 * @param composition: the composition to add.
	 */
	public void addComposition(Composition composition);
	
	/**
	 * Add a composition to the internal composition list.
	 * @param senderID: the ID of the sender model.
	 * @param receiverID: the ID of the receiver model.
	 */
	public void addComposition(int senderID, int receiverID);
	
	/**
	 * Add a composition to the internal composition list.
	 * @param compositionID: the composition ID as a two integers array. 
	 */
	public void addComposition(int[] compositionID);
	
	/**
	 * Get the composition in the internal composition list
	 * having the specified sender ID and receiver ID.
	 * @param senderID: the sender model ID.
	 * @param receiverID: the receiver model ID.
	 * @return the requested composition (null if not found).
	 */
	public Composition getComposition(int senderID, int receiverID);
	
	/**
	 * Get the composition in the internal composition list
	 * having the specified sender ID and receiver ID.
	 * @param compositionID: the composition ID.
	 * @return the requested composition (null if not found).
	 */
	public Composition getComposition(int[] compositionID);
	
	/**
	 * Get the first composition of the internal composition list.
	 * @return the first composition (null if empty).
	 */
	public Composition getFirstComposition();
	
	/**
	 * Get the last composition of the internal composition list.
	 * @return the last composition (null if empty).
	 */
	public Composition getLastComposition();
	
	/**
	 * Remove the specified composition from the internal composition list.
	 * @param composition: the composition to remove.
	 */
	public void removeComposition(Composition composition);
	
	/**
	 * Remove the composition with the specified sender and receiver IDs
	 * from the internal composition list.
	 * @param senderID: the sender ID of the composition.
	 * @param receiverID: the receiver ID of the compostion.
	 */
	public void removeComposition(int senderID, int receiverID);
	
	/**
	 * Remove the composition with the specified composition ID
	 * from the internal composition list.
	 * @param compositionID: the composition ID as a two integers array.
	 */
	public void removeComposition(int[] compositionID);
	
	/**
	 * Internal composition list property.
	 * @return true if the internal composition list is empty,
	 * 		   false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Internal composition list property.
	 * @return the length of the internal composition list.
	 */
	public int size();

	/**
	 * Run a step of the composed simulation.
	 * @param previousOut: the output of the previous model.
	 * @throws EmptyCompositionListException 
	 */
	public void runStep(RunOutput previousOut) throws EmptyCompositionListException;
}
