package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        int n = 100;
        while( n != 0){
            System.out.println("PRESS [1] TO ADD USERS ");
            System.out.println("PRESS [2] TO LIST USERS  ");
            System.out.println("PRESS [3] TO DELETE USERS ");
            System.out.println("PRESS [4] TO EXIT  ");
            n= in.nextInt();

            if(n == 1){
                int id = in.nextInt();
                String login = in.next();
                String password = in.next();
                User user = new User(id, login, password);
                users.add(user);
                saveUserList(users);

            }
            else if(n == 3){
                users = getUsersList();
                System.out.println("Enter id of User");
                int idFind = in.nextInt() ;
                for(int i = 0 ; i < users.size(); i++){
                    if(idFind == users.get(i).getId()){
                        users.remove(i);
                    }
                }
                saveUserList(users);
            }
            else if(n == 2){
                System.out.println("All my account:");
                users = getUsersList();
                for(int i = 0 ; i < users.size() ; i++){
                    System.out.println(users.get(i));
                }
            }

        }
    }

    private static void saveUserList(ArrayList<User> list) throws IOException{
        try {
            FileWriter toFile = new FileWriter("C:\\Users\\HP\\IdeaProjects\\TXT\\src\\com\\company\\User_Data");
            for (int i = 0; i < list.size(); i++) {
                if(i == list.size() - 1){
                    toFile.write(list.get(i).getId() + " " + list.get(i).getLogin() + " " + list.get(i).getPassword());
                }
                else {
                    toFile.write(list.get(i).getId() + " " + list.get(i).getLogin() + " " + list.get(i).getPassword() + "\n");
                }
            }
            toFile.close();
        } catch (IOException e) {
            System.out.println(e);
        }


    }
    public static ArrayList<User> getUsersList() throws IOException {

        FileReader from = new FileReader("C:\\Users\\HP\\IdeaProjects\\TXT\\src\\com\\company\\User_Data");
        Scanner scanner = new Scanner(from);
        ArrayList<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {//true
            int id = scanner.nextInt();
            String login = scanner.next();
            String password = scanner.next();
            User us = new User(id, login, password);
            users.add(us);
        }
        return users;


    }

}
