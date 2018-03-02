package practicalfive.experiment;

import practicalfive.data.ResultsTable;
import practicalfive.sort.Sorter;

import java.util.Random;

/**
 * A RunCampaign class that can run an experiment with a Sorter.
 *
 * @author Gregory M. Kapfhammer
 */

public class RunCampaign implements Campaign {

  /** The starting size for running an experiment campaign. */
  private static final int INPUT_SIZE_START = 250;

  /** The growth factor for input when running an experiment campaign. */
  private static final int INPUT_GROWTH_FACTOR = 2;

  /** The total number of input size doubles to perform for an experiment campaign. */
  private static final int CAMPAIGN_LENGTH = 10;

  /** The indentation level for the output. */
  private static final String IDENTATION = "  ";

  /** Randomly generate data to use for an experiment. */
  public int[] generateRandomData(int size) {
    Random random = new Random();
    int[] generated = new int[size];
    for (int i = 0; i < generated.length; i++) {
      generated[i] = random.nextInt();
    }
    return generated;
  }

  /** Run a Sorter in an experiment campaign. */
  public ResultsTable run(Sorter sort) {
    int campaignRound = 0;
    int currentInputSize = INPUT_SIZE_START;
    ResultsTable results = new ResultsTable(CAMPAIGN_LENGTH);
    // TODO: Add the label indicating that the campaign is starting
    while (campaignRound < CAMPAIGN_LENGTH) {
      int[] generatedInput = generateRandomData(currentInputSize);
      long timeBefore = System.currentTimeMillis();
      sort.sort(generatedInput);
      long timeAfter = System.currentTimeMillis();
      long timeElapsed = timeAfter - timeBefore;
      results.addResult((long)currentInputSize, timeElapsed);
      System.out.println(IDENTATION + "Running round " + campaignRound
          + " with input size " + currentInputSize);
      currentInputSize = currentInputSize * INPUT_GROWTH_FACTOR;
      campaignRound++;
    }
    // TODO: Add the label indicating that the campaign is finished
    return results;
  }

}
