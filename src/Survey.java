import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */

        Scanner scanner = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>();
        int maxAge = 0, minAge = Integer.MAX_VALUE;

        do {

            System.out.println(SurveyQuestions.askToJoin);
            String answer1 = scanner.nextLine();

            if(answer1.toLowerCase().startsWith("y")){
                // Getting participant's name
                System.out.println(SurveyQuestions.askName);
                String name = scanner.nextLine();

                // Getting participant's age
                System.out.println(SurveyQuestions.askAge);
                int age = scanner.nextInt();
                scanner.nextLine();

                // Find the max and min age out of all participants
                if (age > maxAge) maxAge = age;
                if (age < minAge) minAge = age;

                // Getting participant's gender
                System.out.println(SurveyQuestions.askGender);
                char gender = scanner.nextLine().toUpperCase().charAt(0);

                Participant participant = new Participant(name, age, gender);
                participants.add(participant);

                if(gender == 'M') Participant.addMaleParticipants();
                else Participant.addFemaleParticipants();
            }

        } while (Participant.totalNumberOfParticipants < 3);

        for (Participant p : participants) {
            System.out.println(p);
        }

        System.out.println("The total number of male participants is = " + Participant.totalNumberOfMaleParticipants);
        System.out.println("The total number of female participants is = " + Participant.totalNumberOfFemaleParticipants);

        System.out.println("The age of the youngest person is = " + minAge);
        System.out.println("The age of the eldest person is = " + maxAge);
    }
}
