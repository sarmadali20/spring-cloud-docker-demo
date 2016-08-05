docker-compose up -d
echo "Scaling notes micro service to 3"
docker-compose scale notes=3
