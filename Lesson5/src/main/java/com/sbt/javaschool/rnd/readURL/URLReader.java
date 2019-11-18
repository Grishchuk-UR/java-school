package com.sbt.javaschool.rnd.readURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {
    public void readContent(String str) throws IncorrectURL {
        try {
            URL url = new URL(str);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (MalformedURLException e) {
            throw new IncorrectURL("Не правильно введен URL, повторите поытку снова \n");
        } catch (IOException e) {
            throw new IncorrectURL("Не удается получить доступ к сайту: " + str + "проверьте соединение с интернетом");
        } catch (IllegalArgumentException e) {
            throw new IncorrectURL("Не правильно введен URL, повторите поытку снова \n");
        }

    }

}
