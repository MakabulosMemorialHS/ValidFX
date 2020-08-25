#!/bin/bash

(cd ~/developer/ValidFX && java -cp ~/developer/ValidFX/src/main/java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml ph.mmhsvictoria.apps.validfx.ValidFX)

