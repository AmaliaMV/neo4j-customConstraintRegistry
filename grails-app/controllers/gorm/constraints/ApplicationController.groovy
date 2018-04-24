package gorm.constraints

import example.Foo

class ApplicationController {

    def index() {
        respond Foo.getAll()
    }
}
