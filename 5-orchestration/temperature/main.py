from flask import Flask
app = Flask(__name__)


from flask import json


@app.route('/api/temperature')
def temperature():
    data = dict(value=23)
    response = app.response_class(
        response=json.dumps(data),
        status=200,
        mimetype='application/json'
    )
    return response

