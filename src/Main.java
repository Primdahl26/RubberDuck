import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

//TODO: jUnit testing

public class Main {

    public static void main(String[] args) {

        // Field to keep track of the number of queues
        int numberOfQueues=10;

        // Field to keep track of the size of the number ArrayList
        int numberSize = 100;

        // Field to keep track of how long the queue can be
        int queueSpace=10;

        // Field to set what the maximum random number is
        int maxRandomQueueNumber=10;

        // Field to keep track of the number of steps
        int steps=0;

        // Creating 10 queue objects & And an ArrayList to keep them in
        ArrayList<Queue> queueList = new ArrayList<>();
        queueList.add(new Queue(0));
        queueList.add(new Queue(1));
        queueList.add(new Queue(2));
        queueList.add(new Queue(3));
        queueList.add(new Queue(4));
        queueList.add(new Queue(5));
        queueList.add(new Queue(6));
        queueList.add(new Queue(7));
        queueList.add(new Queue(8));
        queueList.add(new Queue(9));


        // Creating a Arraylist that has the size of the numberSize
        ArrayList<Integer> numberList = new ArrayList<>(numberSize);

        // For loop that adds 1-100 in our Arraylist
        for(int i = 1; i <= numberSize; i++) {
            numberList.add(i);
        }

        // An object from the Random class
        Random rand = new Random();

        //A while loop as long as the size of the numberList Arraylist is over 0
        while(numberList.size() > 0) {

            //Make the field index a random number from our ArrayList
            int index = rand.nextInt(numberList.size());

            // If the queues length is not 10 or over, then add an index number to the queue
            if (!(queueList.get(0).size()>=10)) {
                queueList.get(0).enqueue(numberList.remove(index));
            }else if (!(queueList.get(1).size()>=10)){
                queueList.get(1).enqueue(numberList.remove(index));
            }else if (!(queueList.get(2).size()>=10)){
                queueList.get(2).enqueue(numberList.remove(index));
            }else if (!(queueList.get(3).size()>=10)){
                queueList.get(3).enqueue(numberList.remove(index));
            }else if (!(queueList.get(4).size()>=10)){
                queueList.get(4).enqueue(numberList.remove(index));
            }else if (!(queueList.get(5).size()>=10)){
                queueList.get(5).enqueue(numberList.remove(index));
            }else if (!(queueList.get(6).size()>=10)){
                queueList.get(6).enqueue(numberList.remove(index));
            }else if (!(queueList.get(7).size()>=10)){
                queueList.get(7).enqueue(numberList.remove(index));
            }else if (!(queueList.get(8).size()>=10)){
                queueList.get(8).enqueue(numberList.remove(index));
            }else if (!(queueList.get(9).size()>=10)){
                queueList.get(9).enqueue(numberList.remove(index));
            }
        }

        // Print the numbers that are in the queue
        System.out.println("\nQueue 1 numbers: "+queueList.get(0).toString());
        System.out.println("Queue 2 numbers: "+queueList.get(1).toString());
        System.out.println("Queue 3 numbers: "+queueList.get(2).toString());
        System.out.println("Queue 4 numbers: "+queueList.get(3).toString());
        System.out.println("Queue 5 numbers: "+queueList.get(4).toString());
        System.out.println("Queue 6 numbers: "+queueList.get(5).toString());
        System.out.println("Queue 7 numbers: "+queueList.get(6).toString());
        System.out.println("Queue 8 numbers: "+queueList.get(7).toString());
        System.out.println("Queue 9 numbers: "+queueList.get(8).toString());
        System.out.println("Queue 10 numbers: "+queueList.get(9).toString()+"\n");

        System.out.println("Running the rubberduck race!\n");

        System.out.println("Stating Queue size: "+queueSpace);
        System.out.println("Starting Queuelist size: "+numberOfQueues);

        // To run as long as the queueSpace field does not hit 0
        while (!(numberOfQueues == 1)) {

            //Incrementing the steps field
            steps++;
            System.out.println("\nStep number "+steps);

            // Creating randomQueueNumber to see what queue to remove (0-9)
            // So that we can get the placement of the queue on the ArrayList
            int randomQueueNumber = rand.nextInt(maxRandomQueueNumber-1);

            System.out.println("The random rolled number is: "+randomQueueNumber+", so now we remove the number "+randomQueueNumber+" queue");

            // Remove one element from the queue if the queue is not empty
            try {
                for (Queue q : queueList) {
                    if (!q.isEmpty()) {
                        q.dequeue();

                    }
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            // Whenever we remove something from the queue
            // then we also set the maxRandomQueueNumber to one less
            maxRandomQueueNumber--;

            // Update that the queue space is 1 less
            queueSpace--;
            System.out.println("New Queue size: "+queueSpace);

            // Remove the Queue from the Array that the randomQueueNumber rolled
            // but only if that the Size is larger than the randomQueueNumber &
            // if we get the randomQueueNumber in the ArrayList it cannot be null
            // the list also cannot be equals to 1, since we dont want to remove anymore,
            // if we only have 1 element in the Arraylist
            if(randomQueueNumber < queueList.size() && queueList.get(randomQueueNumber) != null && !(queueList.size()==1)) {

                // Removes the random rolled queue number from the list
                queueList.remove(randomQueueNumber);

                // Set the numberOfQueues to 1 less
                numberOfQueues--;

                System.out.println("New Queuelist size: "+queueList.size());
            }
        }
        // Print out the winning rubbberduck number
        System.out.println("\nAnd the winner is: "+queueList.get(0).toString());
    }
}
