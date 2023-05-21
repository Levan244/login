package skypro.exceptions;

import skypro.exceptions.WrongLoginException;
import skypro.exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ввелите логин, пароль, подтвердите парль: ");
        check(input.nextLine(), input.next(), input.next());
    }

    private static boolean check(String login, String pass, String comfirPass) {
        boolean isValid = true;
        try {
            checkLogin(login);
            checkPass(pass, comfirPass);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка с введенным логином: " + e.getMessage());
            isValid = false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка с введенным паролем: " + e.getMessage());
            isValid = false;
        }
        return isValid;


    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин должен содержать  в себе только латинские буквы, цифры и знак подчеркивания.");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длинее 20 символов");
        }

    }

    private static void checkPass(String pass, String comfirPass) throws WrongPasswordException {
        if (!pass.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль должен содержать  в себе только латинские буквы, цифры и знак подчеркивания.");
        } else if (pass.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть длинее 20 символов.");
        } else if (!pass.equals(comfirPass)) {
            throw new WrongPasswordException("Пароль не совпадает.");
        }
    }
}