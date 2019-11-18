package com.sbt.javaschool.rnd.server;

import com.sbt.javaschool.rnd.myExeptions.EmptyUser;
import com.sbt.javaschool.rnd.myExeptions.IncorrectCash;
import com.sbt.javaschool.rnd.myExeptions.IncorrectPin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class TerminalServer {

    private final Map<String, CreditCard> users;

    TerminalServer() {
        users = new HashMap<>();
    }

    public boolean addUser(Integer id, String name, Integer cash, Integer pin) {
        CreditCard newCard = new CreditCard();
        newCard.setId(id);
        newCard.setCash(cash);
        newCard.setUser(name);
        newCard.setPin(pin);
        users.put(name, newCard);
        return true;
    }

    public boolean getCash(String name, Integer pin, Integer cash) throws IncorrectPin, IncorrectCash {
        if (users.get(name).getPin() == pin) {
            if (cash % 100 == 0) {
                Integer temp = users.get(name).getCash();
                if (temp < cash) {
                    //throw
                }
                users.get(name).setCash(temp - cash);
                return true;
            } else {
                throw new IncorrectCash();
            }

        } else {
            throw new IncorrectPin("Не верный пин-код");
            //return 0;
        }
    }

    public int addCash(String name, Integer pin, Integer cash) throws IncorrectCash {
        if (users.get(name).getPin() == pin) {
            if (cash % 100 == 0) {
                Integer temp = users.get(name).getCash() + cash;
                users.get(name).setCash(temp);
                return temp;
            } else {
                throw new IncorrectCash();
            }
        } else {
            // throw new IncorrectPin("Не верный пин-код");
            return 0;
        }
    }

    @NotNull
    private Integer getUser(String name) throws EmptyUser {
        if(!users.isEmpty()){
            try {
                Integer pin = users.get(name).getPin();
                return pin;
            } catch (Exception e) {
                new EmptyUser(name);
            }
        }
        return 0;
    }

}
