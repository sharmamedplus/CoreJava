package com.java.designpatterns._1creational._2factory;

abstract class Computer{
    public abstract int getRam();

    public String toString(){
        return "RAM = "+this.getRam();
    }
}
class ComputerFactory{
    public static Computer getComputer(String type, int ram){
        if("PC".equalsIgnoreCase(type))
            return new Pc(ram);
        else
            return new Server(ram);
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", 10);
        Computer server = ComputerFactory.getComputer("Server", 100);
        System.out.println("PC : "+pc);
        System.out.println("Server : "+server);

    }
}
class Pc extends Computer{

    private int ram;

    public Pc(int ram){
        this.ram = ram;
    }
    public int getRam(){
        return this.ram;
    }
}

class Server extends Computer{
    private int ram;

    public Server(int ram){
        this.ram = ram;
    }
    public int getRam(){
        return this.ram;
    }
}

