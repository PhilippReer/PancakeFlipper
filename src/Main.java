import java.util.Random;

public class Main {


    public static void main(String[] args)
    {
        // these are the variables you may change:
        int numberOfPancakes = 10;                              // how many pancakes are in a row
        int lengthOfFlipper = 3;                                // how many pancakes you can flip at once


        int[] pancakes = new int[numberOfPancakes];


        //Fill the array with random 1s and 0s --> meaning the orientation of the pancakes
        Random rand = new Random();
        for (int i = 0; i < pancakes.length; i++)
        {
            pancakes[i] = rand.nextInt(2);
        }

        //Just print the darn array
        for (int i: pancakes)
        {
            System.out.print(i);
        }

        flipPancakesNumber(pancakes, lengthOfFlipper);



    }

    /**
     * This function flips the pancakes and checks if it is possible to flip them all to one side
     *
     * @param array This is the array in which you save the orientation of your pancakes
     * @param flipperLength You pass the length of your flipper
     */
    private static void flipPancakesNumber(int[] array, int flipperLength)
    {
        int numberOfSwaps = 0;                                          //at first you havent done any swaps yet


        //iterate through the entire array but skip some, since your flipper cant flip outside of the array
        for (int i = 0; i <= array.length-flipperLength; i++)
        {
            if (array[i] == 1)                                          //if the orientation is wrong
            {
                array[i] = 0;                                           //then we flip it
                for (int j = 1; j < flipperLength; j++)                 //and we flip every pancake on the flipper
                {
                    array[i+j] = array[i+j] ^ 1;
                }
                numberOfSwaps++;                                        //we just did 1 flip.
            }
        }

        boolean impossible = false;                                     //now we check if every pancake is in the same  orientation

        for (int i = array.length-flipperLength+1; i < array.length; i++)   //we check the last few pancakes and if any of them are in the wrong orientation its impossible to flip them all in the same orientation
        {                                                                                   //(last few means the last pancakes which will be flipped if the flipper flips the last pancake)
            if (array[i] == 1)
            {
                impossible = true;
                break;
            }
        }
        System.out.print(" Is possible? " + !impossible);


        if (!impossible)
        {
            System.out.print(" Number of Swaps:" + numberOfSwaps);
        }



    }
}





