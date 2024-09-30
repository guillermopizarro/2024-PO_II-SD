const mongoose = require('mongoose')
const schema = mongoose.Schema

const req_string = {
    type: String,
    required: true
}

const req_date = {
    type: Date,
    required: true
}

const usuario_schema = new schema({
    name: req_string,
    lastname: req_string,
    fecha_registro: Date
}, {
    timestamps: { createdAt: 'fecha_registro' }
})

const model = mongoose.model('User', usuario_schema)
module.exports = model