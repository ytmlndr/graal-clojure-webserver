PWD=$(shell pwd)

define pre-compile
	if [ -z "$(GRAAL_HOME)" ]; then echo "ERROR: GRAAL_HOME is not defined"; exit 1; fi
endef

compile:
	$(call pre-compile) && lein native-image

run:
	$(PWD)/target/default+uberjar/server