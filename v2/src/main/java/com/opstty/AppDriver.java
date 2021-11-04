package com.opstty;

import com.opstty.job.KindNumber;
import com.opstty.job.ShowSpecies;
import com.opstty.job.WordCount;
import com.opstty.job.DistrictsContainingTrees;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("districtsTreesContaining", DistrictsContainingTrees.class,
                    "A map/reduce program that counts the number of trees by rounding.");

            programDriver.addClass("showSpecies", ShowSpecies.class,
                    "A map/reduce program that display list of species in the .csv file");

            programDriver.addClass("kindNumber", KindNumber.class,
                    "A map/reduce program that display the kind and number of trees of each kind in tree.csv");

            programDriver.addClass("maxHeightKind", MaxHeightKinds.class,
                    "A map/reduce progarm that list the highest tree by kind from tree.csv");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
