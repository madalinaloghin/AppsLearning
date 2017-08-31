package com.madalinaloghin.masterwidgets.recyclerview;


import com.madalinaloghin.masterwidgets.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dorunechifor.
 */
public class SampleData {
    public static List<Contact> generateSampleContactsList() {
        final List<Contact> contactList = new ArrayList<>();
        
        contactList.add(new Contact("James Butt", "504-621-8927", "jbutt@gmail.com"));
        contactList.add(new Contact("Josephine Darakjy", "810-292-9388", "josephine_darakjy@darakjy.org"));
        contactList.add(new Contact("Art Venere", "856-636-8749", "art@venere.org"));
        contactList.add(new Contact("Lenna Paprocki", "907-385-4412", "lpaprocki@hotmail.com"));
        contactList.add(new Contact("Donette Foller", "513-570-1893", "donette.foller@cox.net"));
        contactList.add(new Contact("Simona Morasca", "419-503-2484", "simona@morasca.com"));
        contactList.add(new Contact("Mitsue Tollner", "773-573-6914", "mitsue_tollner@yahoo.com"));
        contactList.add(new Contact("Leota Dilliard", "408-752-3500", "leota@hotmail.com"));
        contactList.add(new Contact("Sage Wieser", "605-414-2147", "sage_wieser@cox.net"));
        contactList.add(new Contact("Kris Marrier", "410-655-8723", "kris@gmail.com"));
        contactList.add(new Contact("Minna Amigon", "215-874-1229", "minna_amigon@yahoo.com"));
        contactList.add(new Contact("Abel Maclead", "631-335-3414", "amaclead@gmail.com"));
        contactList.add(new Contact("Kiley Caldarera", "310-498-5651", "kiley.caldarera@aol.com"));
        contactList.add(new Contact("Graciela Ruta", "440-780-8425", "gruta@cox.net"));
        contactList.add(new Contact("Cammy Albares", "956-537-6195", "calbares@gmail.com"));
        contactList.add(new Contact("Mattie Poquette", "602-277-4385", "mattie@aol.com"));
        contactList.add(new Contact("Meaghan Garufi", "931-313-9635", "meaghan@hotmail.com"));
        contactList.add(new Contact("Gladys Rim", "414-661-9598", "gladys.rim@rim.org"));
        contactList.add(new Contact("Yuki Whobrey", "313-288-7937", "yuki_whobrey@aol.com"));
        contactList.add(new Contact("Fletcher Flosi", "815-828-2147", "fletcher.flosi@yahoo.com"));
        contactList.add(new Contact("Bette Nicka", "610-545-3615", "bette_nicka@cox.net"));
        contactList.add(new Contact("Veronika Inouye", "408-540-1785", "vinouye@aol.com"));
        contactList.add(new Contact("Willard Kolmetz", "972-303-9197", "willard@hotmail.com"));
        contactList.add(new Contact("Maryann Royster", "518-966-7987", "mroyster@royster.com"));
        contactList.add(new Contact("Alisha Slusarski", "732-658-3154", "alisha@slusarski.com"));
        contactList.add(new Contact("Allene Iturbide", "715-662-6764", "allene_iturbide@cox.net"));
        contactList.add(new Contact("Chanel Caudy", "913-388-2079", "chanel.caudy@caudy.org"));
        contactList.add(new Contact("Ezekiel Chui", "410-669-1642", "ezekiel@chui.com"));
        contactList.add(new Contact("Willow Kusko", "212-582-4976", "wkusko@yahoo.com"));
        
        return contactList;
    }
    
    public static int[] generateSampleColorsArray() {
        final int colors[] = new int[30];
        for (int i = 0; i < 30; i++) {
            colors[i] = Utils.generateRandomColor();
        }
        return colors;
    }
}
