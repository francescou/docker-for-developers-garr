FROM python:2-alpine

RUN pip install flask

USER nobody

EXPOSE 5000

CMD flask run --host=0.0.0.0

ENV FLASK_APP main.py

COPY main.py /
