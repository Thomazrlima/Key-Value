#!/bin/bash

echo "🔧 Iniciando o sistema distribuído Key-Value..."
echo

if ! command -v docker &> /dev/null || ! command -v docker-compose &> /dev/null; then
  echo "❌ Docker ou Docker Compose não encontrados. Instale-os antes de continuar."
  exit 1
fi

echo "🚀 Subindo todos os serviços com build..."
docker compose up --build

echo
echo "✅ Sistema iniciado com sucesso!"
echo "📌 API Gateway: http://localhost:8080"
echo "📌 Swagger UI:  http://localhost:8080/swagger-ui.html"
echo "📌 Eureka UI:   http://localhost:8761"
echo "📌 Health API:  http://localhost:8081/actuator/health"
