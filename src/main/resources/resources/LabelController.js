var LabelApp = angular.module('LabelApp');

LabelApp.controller('LabelController', LabelController, [ 'LabelResource' ]);

function LabelController($scope, LabelResource, $timeout) {

	var model = {
		labelsFromList : [],
		message : null,
		isError : false
	};

	function setMessage(msg, isError, timeout) {
		model.message = msg;
		model.isError = isError;
		if (timeout) {
			$timeout(clearMessage, timeout);
		}
	}

	function clearMessage() {
		setMessage('', false);
	}

	function getAllLabels() {
		clearMessage();
		LabelResource.query(onSuccess, onFailure);
		function onSuccess(labelList) {
			model.labelsFromList = labelList;
		}
		function onFailure() {
			setMessage('Failed, can\'t get labels.', true);
		}
	}

	function addLabel() {
		clearMessage();
		var label = {
			labelText : model.newLabelText,
			labelDate : model.newLabelDate
		};

		LabelResource.save(label, onSuccess, onFailure)

		function onSuccess(savedLabel) {
			setMessage('Label saved.', false, 2000);
			model.labelsFromList.push(savedLabel);
		}

		function onFailure() {
			setMessage('Failed, can\'t add label', true);
		}
	}

	function delLabel(labelId) {
		clearMessage();

		LabelResource.remove({
			id : labelId
		}, onSuccess, onFailure)

		function onSuccess() {
			getAllLabels();
			setMessage('Label deleted.', false, 2000);
		}
		function onFailure() {
			setMessage('Failed, can\'t exterminate label', true);
		}
	}

	function updateLabel(label) {
		clearMessage();

		LabelResource.update(label, onSuccess, onFailure)

		function onSuccess(savedLabel) {
			setMessage('Label updated.', false, 2000);
			model.labelsFromList.push(savedLabel);
			getAllLabels();
		}
		function onFailure() {
			setMessage('Failed, can\'t update label', true);
		}
	}

	$scope.model = model;
	$scope.addLabel = addLabel;
	$scope.delLabel = delLabel;
	$scope.updateLabel = updateLabel;

	getAllLabels();
}
