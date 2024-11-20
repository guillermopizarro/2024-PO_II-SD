const express = require('express')

const config = require('./config')

let app = express()
const server = require('http').Server(app)
const io = require('socket.io')(server)

app.use('/', express.static('public'))

io.on('connection', function(socket){
    console.log('Nuevo cliente conectado.')
    socket.emit('mensaje', 'Bienvenido')
})

let contador = 1;

setInterval(function(){
    io.emit(`mensaje`, `Hola, saludos a todos --> ${contador}`)
    contador++
}, 5000)

server.listen(config.PORT, function() {
    console.log(`La aplicacion esta escuchando en http://localhost:${config.PORT}`)
})