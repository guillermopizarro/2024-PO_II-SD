const express = require('express')
const body_parser = require('body-parser')

var app = express()

app.use( body_parser.json() )
app.use( body_parser.urlencoded({extended:false}) )

app.listen( 3000 )
console.log(`La aplicacion se encuentra arriba en http://localhost:3000`)