package com.java.designpatterns._1creational._3abstractfactory;

abstract class Computer{
    abstract int getRam();

    public String toString(){
        return "RAM : "+this.getRam();
    }
}

class Pc extends Computer{

    private int ram;

    public Pc(int ram){
        this.ram = ram;
    }
    @Override
    public int getRam() {
        return this.ram;
    }
}

class Server extends Computer{

    private int ram;

    public Server(int ram){
        this.ram = ram;
    }
    @Override
    public int getRam() {
        return this.ram;
    }
}
interface ComputerAbstractFactory{
    Computer createComputer();
}

class PcFactory implements ComputerAbstractFactory{
    private int ram;

    public PcFactory(int ram){
        this.ram = ram;
    }

    @Override
    public Computer createComputer() {
        return new Pc(this.ram);
    }
}

class ServerFactory implements ComputerAbstractFactory{
    private int ram;
    public ServerFactory(int ram){
        this.ram = ram;
    }
    @Override
    public Computer createComputer() {
        return new Server(this.ram);
    }
}
class ComputerFactory{

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PcFactory(10));
        Computer server = ComputerFactory.getComputer(new ServerFactory(100));
        System.out.println("PC = "+pc);
        System.out.println("Server = "+server);
    }
}
