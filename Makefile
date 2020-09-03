serve:
	make -j 2 serve~app serve~api

serve~app:
	cd app && yarn serve

serve~api:
	cd api && ./mvnw quarkus:dev
