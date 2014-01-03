/**
 * @author appelgriebsch
 */

/**
 *
 * @param xhr
 * @param status
 * @param args
 */
function handleLoginRequest(xhr, status, args) {

    if (args.validationFailed || !args.loggedIn) {
        jQuery('#logindialog').effect("shake", { times:3 }, 100);
    } else {
        pnlUserLogin.hide();
    }
}

/**
 *
 * @param xhr
 * @param status
 * @param args
 */
function handleRegistrationRequest(xhr, status, args) {

    if (args.validationFailed || !args.registered) {
        jQuery("#registrationwizard").effect("shake", { times:3 }, 100);
    } else {
        wzdUserRegistration.hide();
        if (args.redirectUrl != null) {
            setTimeout(redirectTo(args.redirectUrl), 3000);
        }
    }
}

/**
 *
 * @param xhr
 * @param status
 * @param args
 */
function handleRatingRequest(xhr, status, args) {

    if (args.validationFailed || !args.ratingFinished) {
        jQuery('#ratingDialog').effect("shake", { times:3 }, 100);
    } else {
        pnlRatingDialog.hide();
    }
}

/**
 *
 * @param xhr
 * @param status
 * @param args
 */
function handleChangePinRequest(xhr, status, args) {

    if (args.validationFailed || !args.changedPin) {
        jQuery('#changePinDialog').effect("shake", { times:3 }, 100);
    } else {
        pnlChangePinDialog.hide();
    }
}
/**
 *
 * @param xhr
 * @param status
 * @param args
 */
function handlePageNavigationRequest(xhr, status, args) {

    if (args.redirectUrl != null) {

        setTimeout(redirectTo(args.redirectUrl), 3000);
    }
}

/**
 *
 * @param redirectUrl
 */
function redirectTo(redirectUrl) {

    window.location = redirectUrl;
}
