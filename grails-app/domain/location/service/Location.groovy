package location.service

import grails.rest.Resource

@Resource(uri='/location', formats=['json', 'xml'])
class Location {

    int id
    String location
    String description
    BigDecimal latitude
    BigDecimal longitude


    static constraints = {
        id blank: false, unique: true
        location blank: false
        description blank:  false
        latitude( scale : 16 )
        longitude( scale : 16 )
    }

}
