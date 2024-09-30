const storage = require('./storage')

function insert_user( dato ) {
    return new Promise( (resolve, reject) => {
        if (!dato.name || !dato.lastname ) {
            reject( 'Los datos se encuentran incompletos.' )
        } else {
            resolve( storage.insert( dato ) )
        }
    } )
}

function get_user( dato ) {
    return new Promise( (resolve, reject) => {
        if (!dato) {
            reject( 'No existen datos' )
        } else {
            resolve( storage.get( dato ) )
        }
    } )
}

module.exports = {
    insert_user,
    get_user
}