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

