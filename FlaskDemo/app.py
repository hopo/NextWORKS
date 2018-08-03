from flask import Flask, render_template
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient('localhost', 27017)
db = client['db_sliver']

@app.route("/")
def home_page():
    item = db.mycol.find()

    return render_template("index.html", item=item)

