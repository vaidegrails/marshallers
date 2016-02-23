import com.vaidegrails.Car
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        new Car(maker: "Porsche", model: "GT9-R", price: 680000, speed: 414, power: 824).save(failOnError: true)
        new Car(maker: "Audi", model: "RS6 MTM Clubsport", price: 500000, speed: 350, power: 537).save(failOnError: true)
        new Car(maker: "Mercedes-Benz", model: "C 63 AMG Edo Competition T-Model ", price: 280000, speed: 343, power: 441).save(failOnError: true)
        new Car(maker: "BMW", model: "M3 Manhart Racing V8R Biturbo ", price: 300000, speed: 338, power: 513).save(failOnError: true)

        JSON.registerObjectMarshaller(Car, { car ->
            return [id: car.id, model: car.model, 'speed (in kilometers)': car.speed]
        })
    }
    def destroy = {
    }
}
