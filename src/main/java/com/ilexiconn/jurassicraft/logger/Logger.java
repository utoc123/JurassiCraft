package com.ilexiconn.jurassicraft.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger
{
    public void print(LogType type, String message)
    {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

        switch (type)
        {
            case INFO:
                System.out.println("[" + time + "] [JurassiCraft/INFO] " + message);
                break;
            case WARNING:
                System.out.println("[" + time + "] [JurassiCraft/WARNING] " + message);
                break;
            case ERROR:
                System.err.println("[" + time + "] [JurassiCraft/ERROR] " + message);
                break;
        }
    }
}
