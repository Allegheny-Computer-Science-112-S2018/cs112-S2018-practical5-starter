package practicalfive.experiment;

import practicalfive.data.ResultsTable;
import practicalfive.sort.Sorter;

/**
 * A Campaign interface used to run an experiment.
 *
 * @author Gregory M. Kapfhammer
 */

public interface Campaign {

  /** Require that any Campaign implementer can run a Sorter in an experiment. */
  public ResultsTable run(Sorter sort);

}
