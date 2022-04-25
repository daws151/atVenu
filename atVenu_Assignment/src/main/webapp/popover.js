/* Author: Brett Dawson
* This was my failed attempt at adding a popover when click on the 'More' button.
* I tried using the 'Popper' JS library (https://popper.js.org/) for this. I got it to display on document load but could
* not get it to respond to mouse clicks on the 'More button. So it's hidden.
*/
/* I had to use an absolute path in my import because the browser was showing a warning in the browser's Inspect/Dev Tools
about not having an import statement on the first line for some reason. Sort of a strange error because it worked with a
relative path ('@popperjs/core'). I added the absolute path to get rid of the warning.
* */
import { createPopper } from 'C:/Users/daws1/IdeaProjects/atVenu_Assignment/node_modules/@popperjs/core';

const button = document.querySelector("#moreBtn");
const tooltip = document.querySelector("#tooltip");
const popperInstance = createPopper(button, tooltip);
// Display 'More' popover
function show() {
    tooltip.setAttribute('data-show', '');
    popperInstance.update();
}

function hide() {
    tooltip.removeAttribute('data-show');
    popperInstance.update();
}
const showEvents = ['click', 'focus'];
const hideEvents = ['click', 'hide'];

showEvents.forEach((event) =>{
    button.addEventListener(event, show);
});

hideEvents.forEach((event)=>{
    button.addEventListener(event, hide);
});

