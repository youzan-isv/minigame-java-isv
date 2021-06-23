import React from "react"
import {HashRouter as Router, Route, hashHistory } from "react-router-dom"
import Page from "../components/Page"

function router() {
    return (
        <Router history={hashHistory}>
            <Route exact path="/" component={Page} />
        </Router>
    )
}

export default router
