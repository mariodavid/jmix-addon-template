[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![GitHub release](https://img.shields.io/github/release/mariodavid/jmix-addon-template.svg)](https://github.com/mariodavid/jmix-addon-template/releases/)
![CI Pipeline](https://github.com/mariodavid/jmix-addon-template/actions/workflows/test.yml/badge.svg)
[![Example](https://img.shields.io/badge/example-jmix--wizard--example-brightgreen)](https://github.com/mariodavid/jmix-addon-template-example)
[![Jmix Marketplace](https://img.shields.io/badge/marketplace-jmix--wizard-orange)](https://www.jmix.io/marketplace/wizard)


# Jmix Addon Template

This addon template shows a working example of an integration with Github actions and Github Package registry.

It contains:

* run tests (on main branch and in PRs) 
  * in-memory HSQLDB
  * Junit test results in pipeline
* publish release to Github Packages

## Prerequisite

Install [Github CLI](https://cli.github.com/) 

## Create a release

In order to create a release, the following command can be used:
`gh release create 0.0.1`

The release is published in the [Github package registry or your account](https://github.com/mariodavid?tab=packages&repo_name=jmix-addon-template). 

