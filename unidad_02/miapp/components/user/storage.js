const model = require('./model')

async function insert_user(dato) {
    const resultado = await new model(dato)
    return resultado.save()
}

async function get_user(dato) {
     let filter = {}
     
     const resultado = await model.find( filter )
     return resultado
}

module.exports = {
    insert:insert_user,
    get:get_user,
}