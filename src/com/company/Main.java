package com.company;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
	    // Создаём скрипт для обработки JavaScript
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // создаём переменную
        engine.put("k", 4);

        // прописываем код (вывод на экран, функцию, переменную и то что вернуть)
        String codeToJavaScript = "print('hello');"+
                "function f(a){return a+7;};"+
                "var n=1+2;"+
                "n+3+k"; // сложение, вернёться

        // после обработки кода, получаем вывод на экран и возврат сложения
        Object o1 = engine.eval(codeToJavaScript);
        System.out.println(o1);

        // вызов функиции из JavaScript
        Object o2 = ((Invocable)engine).invokeFunction("f", 1);
        Object o3 = ((Invocable)engine).invokeFunction("f", "1");
        System.out.println(o2+" | "+o3);

        // вызов переменной
        System.out.println(engine.get("n"));
    }
}
