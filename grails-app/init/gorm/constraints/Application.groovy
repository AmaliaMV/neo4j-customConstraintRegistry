package gorm.constraints

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import example.BarConstraint

class Application extends GrailsAutoConfiguration {



    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

}