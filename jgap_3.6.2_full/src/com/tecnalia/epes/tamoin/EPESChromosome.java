package com.tecnalia.epes.tamoin;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.IChromosomePool;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;

public class EPESChromosome extends Chromosome {

	private static final long serialVersionUID = 1L;

	public EPESChromosome() throws InvalidConfigurationException {
		super();
	}

	public EPESChromosome(Configuration config, Gene[] sampleGenes)
			throws InvalidConfigurationException {
		super(config, sampleGenes);
	}

	// The static modifier of this method was removed in the original Chromosome class
	public IChromosome randomInitialChromosome(
			Configuration a_configuration) throws InvalidConfigurationException {
		// Sanity check: make sure the given configuration isn't null.
		// -----------------------------------------------------------
		if (a_configuration == null) {
			throw new IllegalArgumentException(
					"Configuration instance must not be null");
		}
		// Lock the configuration settings so that they can't be changed
		// from now on.
		// -------------------------------------------------------------
		a_configuration.lockSettings();
		// First see if we can get a Chromosome instance from the pool.
		// If we can, we'll randomize its gene values (alleles) and then
		// return it.
		// -------------------------------------------------------------
		IChromosomePool pool = a_configuration.getChromosomePool();
		if (pool != null) {
			IChromosome randomChromosome = pool.acquireChromosome();
			if (randomChromosome != null) {
				Gene[] genes = randomChromosome.getGenes();
				RandomGenerator generator = a_configuration
						.getRandomGenerator();
				for (int i = 0; i < genes.length; i++) {				
					genes[i].setToRandomValue(generator);					
					/** @todo what about Gene's energy? */
				}
				randomChromosome
						.setFitnessValueDirectly(FitnessFunction.NO_FITNESS_VALUE);
				return randomChromosome;
			}
		}
		// We weren't able to get a Chromosome from the pool, so we have to
		// construct a new instance and build it from scratch.
		// ------------------------------------------------------------------
		IChromosome sampleChromosome = a_configuration.getSampleChromosome();
		sampleChromosome.setFitnessValue(FitnessFunction.NO_FITNESS_VALUE);
		Gene[] sampleGenes = sampleChromosome.getGenes();
		Gene[] newGenes = new Gene[sampleGenes.length];
		RandomGenerator generator = a_configuration.getRandomGenerator();
		for (int i = 0; i < newGenes.length; i++) {
			// We use the newGene() method on each of the genes in the
			// sample Chromosome to generate our new Gene instances for
			// the Chromosome we're returning. This guarantees that the
			// new Genes are setup with all of the correct internal state
			// for the respective gene position they're going to inhabit.
			// -----------------------------------------------------------
			newGenes[i] = sampleGenes[i].newGene();
			((MaintenanceTaskGene) newGenes[i])
			.setWindFarm(((MaintenanceTaskGene) sampleGenes[i])
					.getWindFarm());			
			((MaintenanceTaskGene) newGenes[i])
					.setDuration(((MaintenanceTaskGene) sampleGenes[i])
							.getDuration());
			((MaintenanceTaskGene) newGenes[i])
			.setDurationSecondDay(((MaintenanceTaskGene) sampleGenes[i])
					.getDurationSecondDay());
			((MaintenanceTaskGene) newGenes[i])
			.setDurationThirdDay(((MaintenanceTaskGene) sampleGenes[i])
					.getDurationThirdDay());
			((MaintenanceTaskGene) newGenes[i])
			.setWindTurbine(((MaintenanceTaskGene) sampleGenes[i])
					.getWindTurbine());
			((MaintenanceTaskGene) newGenes[i])
			.setName(((MaintenanceTaskGene) sampleGenes[i])
					.getName());
			((MaintenanceTaskGene) newGenes[i])
			.setMaintenanceTeams(((MaintenanceTaskGene) sampleGenes[i])
					.getMaintenanceTeams());
			((MaintenanceTaskGene) newGenes[i])
			.setMaintenanceTeamNames(((MaintenanceTaskGene) sampleGenes[i])
					.getMaintenanceTeamNames());
			((MaintenanceTaskGene) newGenes[i])
			.setPriority(((MaintenanceTaskGene) sampleGenes[i])
					.getPriority());	
			((MaintenanceTaskGene) newGenes[i])
			.setWindSpeedLimit(((MaintenanceTaskGene) sampleGenes[i])
					.getWindSpeedLimit());
			// If application data is set, try to clone it as well.
			// ----------------------------------------------------
			Object appData = sampleGenes[i].getApplicationData();
			if (appData != null) {
				try {
					cloneObject(a_configuration, appData, sampleChromosome);
				} catch (Exception ex) {
					throw new InvalidConfigurationException(
							"Application data of "
									+ "sample chromsome is not cloneable", ex);
				}
			}
			// Set the gene's value (allele) to a random value.
			// ------------------------------------------------
			newGenes[i].setToRandomValue(generator);
			/** @todo what about Gene's energy? */
		}
		// Finally, construct the new chromosome with the new random
		// genes values and return it.
		// ---------------------------------------------------------
		return new Chromosome(a_configuration, newGenes);
	}
}
