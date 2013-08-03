def _pick_pivot_index(list_length_range):
    # FIXME: pick pivot in a smarter way if possible
    pivot = list_length_range[0]
    return pivot


def quicksort(unsorted_list):

    # Define base case
    if len(unsorted_list) <= 1:
        return unsorted_list

    # Choose a pivot based on sub-list
    pivot_index = _pick_pivot_index(range(len(unsorted_list)))
    pivot = unsorted_list[pivot_index]
    less_list = []
    greater_list = []

    # Separate into greater than or less than pivot
    for i in range(len(unsorted_list)):
        if i == pivot_index:
            continue

        if unsorted_list[i] <= pivot:
            less_list.append(unsorted_list[i])
        else:
            greater_list.append(unsorted_list[i])

    # Recurse on sub-lists
    return_list = quicksort(less_list)
    return_list.append(pivot)
    return_list.extend(quicksort(greater_list))

    return return_list
