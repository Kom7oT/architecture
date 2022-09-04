package ru.geekbrains.patterns.structural.facade;

public class ComputerFacade {

    protected Computer computer;

    public ComputerFacade(Computer computer) {
        this.computer = computer;
    }

    public void turnOn(){
        System.out.println(this.computer.getElectricShock());
        System.out.printf(this.computer.makeSound());
        System.out.printf(this.computer.showLoadingScreen());
        System.out.println(this.computer.bam());
    }

    public void turnOff(){
        this.computer.closeEverything();
        this.computer.pullCurrent();
        this.computer.sooth();
    }

}
