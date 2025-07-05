FROM python:3.10-slim
WORKDIR /app

COPY . .
RUN pip install -r python-libs.txt

EXPOSE 6000
CMD ["python", "listing_service.py", "--port=6000", "--debug=true"]
