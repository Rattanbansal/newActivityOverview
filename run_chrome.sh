#!/usr/bin/env bash

set -xe

#docker run -t --rm -v /home/intersoft-admin/Rattan/Katalon/newActivityOverview:/katalon/katalon/source katalonstudio/katalon katalon-execute.sh -browserType="Chrome" -retry=0 -statusDelay=15 -testSuitePath="Test Suites/ActivityOverview-FiltersAndColumns" -apiKey="22937998-3f24-4da4-aedb-4d9bae4a896d" -executionProfile="Development"

docker run -t --rm -v /tmp:/katalon/katalon/source katalonstudio/katalon katalon-execute.sh -browserType="Chrome" -retry=0 -statusDelay=15 -testSuitePath="Test Suites/ActivityOverview-FiltersAndColumns" -apiKey="22937998-3f24-4da4-aedb-4d9bae4a896d" -executionProfile="Development"
